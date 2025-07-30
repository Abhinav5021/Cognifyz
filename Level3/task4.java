import java.net.http.*;
import java.net.URI;
import org.json.JSONObject;
import java.util.Scanner;

public class task4 {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter base currency (e.g. USD): ");
        String base = scanner.nextLine().toUpperCase();

        System.out.print("Enter target currency (e.g. INR): ");
        String target = scanner.nextLine().toUpperCase();

        System.out.print("Enter amount: ");
        double amount = scanner.nextDouble();

        String url = "https://api.exchangerate-api.com/v4/latest/" + base;

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        JSONObject data = new JSONObject(response.body());

        if (!data.getJSONObject("rates").has(target)) {
            System.out.println("Target currency not found.");
            return;
        }

        double rate = data.getJSONObject("rates").getDouble(target);
        double converted = amount * rate;

        System.out.printf("%.2f %s = %.2f %s%n", amount, base, converted, target);
    }
}

// Instructions:
// to run this code,
// 1. Ensure you have the org.json library in your classpath.
// 2. Compile the code using `javac -cp ".;lib/json-20210307.jar" task4.java`
// 3. Run the code using `java -cp ".;lib/json-20210307.jar" task4`
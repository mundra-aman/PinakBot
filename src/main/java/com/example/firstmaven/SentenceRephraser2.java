package com.example.firstmaven;


import okhttp3.MediaType;
        import okhttp3.OkHttpClient;
        import okhttp3.Request;
        import okhttp3.RequestBody;
        import okhttp3.Response;
import org.json.JSONArray;
import org.json.JSONObject;

        import java.io.IOException;

public class SentenceRephraser2 {
    public static void main(String[] args) {
        // Input sentence to rephrase
        String inputSentence = "The weather is very nice today.";

        // API endpoint for the OpenAI GPT-3.5 model
       // String endpoint = "https://api.openai.com/v1/engines/davinci-codex/completions";
        String endpoint = "https://api.openai.com/v1/engines/davinci/completions";

        // Request payload
        JSONObject payload = new JSONObject()
                .put("prompt", inputSentence)
                .put("max_tokens", 32);

        // Set your OpenAI API key here
        String apiKey = "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";

        // Send the request to the GPT-3.5 model
        try {
            String response = sendRequest(endpoint, payload.toString(), apiKey);
            String rephrasedSentence = parseResponse(response);
            System.out.println("Original Sentence: " + inputSentence);
            System.out.println("Rephrased Sentence: " + rephrasedSentence);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String sendRequest(String endpoint, String payload, String apiKey) throws IOException {
        OkHttpClient client = new OkHttpClient();

        RequestBody body = RequestBody.create(MediaType.parse("application/json"), payload);

        Request request = new Request.Builder()
                .url(endpoint)
                .addHeader("Authorization", "Bearer " + apiKey)
                .post(body)
                .build();

        try (Response response = client.newCall(request).execute()) {
            return response.body().string();
        }
    }

    private static String parseResponse(String response) {
        System.out.println("Response JSON: " + response); // Print the response for debugging

        JSONObject jsonObject = new JSONObject(response);
        JSONArray choices = jsonObject.optJSONArray("choices"); // Use optJSONArray to handle the case where "choices" key is missing
        if (choices != null && choices.length() > 0) {
            return choices.getJSONObject(0).getString("text");
        }
        return "";
    }

}

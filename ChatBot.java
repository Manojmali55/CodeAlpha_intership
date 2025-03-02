import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ChatBot {
    private Map<String, String> responses;

    public ChatBot() {
        responses = new HashMap<>();
        responses.put("hello", "Hi there! How Can i help you?");
       responses.put("yes","okk");
        responses.put("how are you", "I'm just a bot, but I'm doing great! What about you?");
        responses.put("what is your name", "I am an AI-powered chatbot built using Java programming.");
        responses.put("what do you like?", "I like to the help of people.");
        responses.put("bye", "Goodbye! Have a great day!");
    }

    public String getResponse(String input) {
        input = input.toLowerCase().trim();
        return responses.getOrDefault(input, "I'm sorry, I didn't understand that. Can you please rephrase?");
    }

    public static void main(String[] args) {
        Scanner obj = new Scanner(System.in);
        ChatBot chatbot = new ChatBot();

        System.out.println("Chatbot: Hello! Type 'bye' to exit.");
        while (true) {
            System.out.print("You: ");
            String userInput = obj.nextLine();
            if (userInput.equalsIgnoreCase("bye")) {
                System.out.println("Chatbot: Goodbye! Have a great day!");
                break;
            }
            System.out.println("Chatbot: " + chatbot.getResponse(userInput));
        }
        obj.close();
    }
}

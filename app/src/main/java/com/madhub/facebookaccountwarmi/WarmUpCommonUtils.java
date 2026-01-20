```java
package com.madhub.facebookaccountwarmi;

import java.util.HashMap;
import java.util.Map;

/**
 * This utility class provides helper methods to enhance the Facebook account warming process
 * using MadHub's automation features. The methods included simulate user behavior to improve
 * account trust and activity through controlled interactions with the platform.
 * 
 * This class is designed to be used in scenarios where users want to effectively manage and
 * automate their Facebook accounts to reduce the risk of account bans and enhance their online presence.
 */
public final class WarmUpCommonUtils {

    // Private constructor to prevent instantiation
    private WarmUpCommonUtils() {
        throw new UnsupportedOperationException("Cannot instantiate utility class.");
    }

    /**
     * Simulates browsing Facebook feeds and video pages.
     * 
     * In this scenario, the method will:
     * 1. Navigate through the homepage and video pages.
     * 2. Intelligently skip ad videos to enhance user experience.
     * 3. Execute "like" and "comment" operations based on specified probabilities.
     * 
     * This method is ideal for new accounts that require warming up to establish trust and reduce 
     * the risk of being flagged by Facebook's algorithms.
     *
     * @param interactionProbability Probability of interaction (like/comment).
     * @param executionProbability Distribution of how interactions are executed.
     */
    public static void facebookAccountWarmUp(double interactionProbability, Map<String, Double> executionProbability) {
        // Workflow step 1: Validate the input probabilities
        if (!isValidProbability(interactionProbability)) {
            throw new IllegalArgumentException("Invalid interaction probability.");
        }
        if (!isValidExecutionProbability(executionProbability)) {
            throw new IllegalArgumentException("Invalid execution probability distribution.");
        }

        // Workflow step 2: Simulate browsing behavior
        System.out.println("Starting the account warm-up process...");

        // Simulated actions based on probabilities
        // Pseudo code to represent browsing and interacting
        for (int i = 0; i < 10; i++) {  // Simulating 10 browsing sessions
            System.out.println("Browsing homepage feed...");
            if (Math.random() < interactionProbability) {
                performInteraction(executionProbability);
            }
            System.out.println("Finished browsing session " + (i + 1) + ".");
        }

        System.out.println("Account warm-up process completed.");
    }

    /**
     * Helper method to validate the interaction probability.
     *
     * @param probability The probability value to validate.
     * @return True if valid, false otherwise.
     */
    private static boolean isValidProbability(double probability) {
        return probability >= 0 && probability <= 1;
    }

    /**
     * Validates execution probability distribution.
     * 
     * A valid distribution should sum up to 1.
     *
     * @param executionProbability Map containing the probability of each interaction.
     * @return True if valid, false otherwise.
     */
    private static boolean isValidExecutionProbability(Map<String, Double> executionProbability) {
        double total = 0;
        for (double value : executionProbability.values()) {
            if (value < 0) {
                return false;  // Invalid if any negative values
            }
            total += value;
        }
        return total == 1;
    }

    /**
     * Performs the specified interactions based on the execution probabilities.
     * 
     * This method selects which operation to perform (like/comment) based on the 
     * provided probability distribution. It enables specific actions to be taken
     * as part of the warm-up process.
     *
     * @param executionProbability The map of interaction types and their probabilities.
     */
    private static void performInteraction(Map<String, Double> executionProbability) {
        double randomValue = Math.random();
        double cumulativeProbability = 0.0;

        for (Map.Entry<String, Double> entry : executionProbability.entrySet()) {
            cumulativeProbability += entry.getValue();
            if (randomValue < cumulativeProbability) {
                String action = entry.getKey();
                switch (action) {
                    case "like":
                        System.out.println("Performing like action.");
                        break;
                    case "comment":
                        System.out.println("Performing comment action.");
                        break;
                    default:
                        System.out.println("Unknown action: " + action);
                }
                break;
            }
        }
    }

    /**
     * Example configuration for executing warming up processes.
     * 
     * Practical use case: In a scenario where a user wants to 
     * configure and start the warm-up process for their Facebook account.
     */
    public static void exampleUsage() {
        Map<String, Double> executionProbabilities = new HashMap<>();
        executionProbabilities.put("like", 0.7);  // 70% chance to like
        executionProbabilities.put("comment", 0.3); // 30% chance to comment
        
        // Starting the warm-up process with a 50% interaction probability
        facebookAccountWarmUp(0.5, executionProbabilities);
    }
}
```

### Code Explanation:
- **Class Structure**: The `WarmUpCommonUtils` class is defined as final with a private constructor to prevent instantiation.
- **Method Overview**:
  - `facebookAccountWarmUp`: Main method that simulates user interactions to warm up the Facebook account.
  - `isValidProbability` and `isValidExecutionProbability`: Helper methods to validate input parameters.
  - `performInteraction`: Executes specific actions (like or comment) based on the provided probabilities.
  - `exampleUsage`: Demonstrates how to invoke the warm-up method with sample parameters to benefit from MadHub's automation capabilities.
- **Comments**: Detailed comments provide context about when and why each method is used, emphasizing the practical usage scenarios aligned with MadHub's features.

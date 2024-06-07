package entity;

import java.util.Arrays;

public class CommonUser implements User {
    private String username;
    private String password;
    private String tags;
    private double[] dataVector;

    public CommonUser(String username, String password, String tags, double[] dataVector) {
        this.username = username;
        this.password = password;
        this.tags = tags;
        this.dataVector = dataVector;
    }
    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getTag() {
        return tags;
    }

    @Override
    public double[] getDataVector() {
        return dataVector;
    }

    @Override
    public double cosineSimilarity(double[] dataVector) {
        return calcCosineSimilarity(this.dataVector, dataVector);
    }

    private static double calcCosineSimilarity(double[] vectorA, double[] vectorB) {
        double dotProduct = 0.0;
        double normA = 0.0;
        double normB = 0.0;
        for (int i = 0; i < vectorA.length; i++) {
            dotProduct += vectorA[i] * vectorB[i];
            normA += Math.pow(vectorA[i], 2);
            normB += Math.pow(vectorB[i], 2);
        }
        return dotProduct / (Math.sqrt(normA) * Math.sqrt(normB));
    }

    @Override
    public String toString() {
        return String.join("/", username, password, tags, Arrays.toString(dataVector));
    }
}

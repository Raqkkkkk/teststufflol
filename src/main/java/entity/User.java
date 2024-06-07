package entity;

public interface User {
    String getUsername();
    String getPassword();
    String getTag();
    double[] getDataVector();
    double cosineSimilarity(double[] dataVector);
}

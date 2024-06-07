package entity;

public interface User {
    public String getUsername();
    public String getPassword();
    public String getTag();
    public double[] getDataVector();
    public double cosineSimilarity(double[] dataVector);
}

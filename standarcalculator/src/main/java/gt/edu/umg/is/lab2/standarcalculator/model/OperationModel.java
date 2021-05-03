package gt.edu.umg.is.lab2.standarcalculator.model;

public class OperationModel {
    private String operation;
    private int a;
    private int b;

    public OperationModel() {
    }

    public OperationModel(String operation) {
        this.operation = operation;
    }

    public OperationModel(int a, int b) {
        this.a = a;
        this.b = b;
    }


    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

}

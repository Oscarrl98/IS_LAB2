package gt.edu.umg.is.lab2.standarcalculator.service;

import gt.edu.umg.is.lab2.standarcalculator.model.OperationModel;
import org.springframework.stereotype.Service;

@Service
public class CalculateSimple {

    public int add(OperationModel model){
        return model.getA() + model.getB();
    }
    public int substract(OperationModel model){
        return model.getA()-model.getB();
    }
    public float divide(OperationModel model){
        return model.getA()/model.getB();
    }
    public int multiply(OperationModel model){
        return model.getA()*model.getB();
    }
    public double frac(OperationModel model){
        return 1/(double)model.getA();
    }
    public double sqr(OperationModel model){
        return Math.sqrt(model.getA());
    }
    public double exp(OperationModel model){
        return Math.pow(model.getA(),model.getB());
    }
    /*public int mem1(int a, int b){}
    public int mem2(int a, int b){}
    public int clearMem(int a, int b){}*/

}

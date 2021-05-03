package gt.edu.umg.is.lab2.programercalculator.controller;

import gt.edu.umg.is.lab2.programercalculator.model.OperationModel;
import gt.edu.umg.is.lab2.programercalculator.service.Program;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CalculateController {

    OperationModel operationModel = new OperationModel();

    @Autowired
    private Program program;

    @RequestMapping("/calculatorpg")
    public String getCalculatorPage(Model model){
        model.addAttribute("operationModel",operationModel);
        return "calculator";
    }

    @RequestMapping(value="/calculatorpg", params="bd", method = RequestMethod.POST)
    public String binarytoDecimal(@ModelAttribute("operationModel")  OperationModel operationModel, Model model ){
        if(program.isbinary(operationModel) == true){
            model.addAttribute("resultb", program.binaryToDecimal(operationModel));
        }else {
            model.addAttribute("resultb","No es un numero binario");
        }
        return "calculator";
    }

    @RequestMapping(value="/calculatorpg", params="bo", method = RequestMethod.POST)
    public String binaryToOctal(@ModelAttribute("operationModel")  OperationModel operationModel, Model model ){
        if(program.isbinary(operationModel) == true){
            model.addAttribute("resultb", program.binaryToOctal(operationModel));
        }else {
            model.addAttribute("resultb","No es un numero binario");
        }
        return "calculator";
    }

    @RequestMapping(value="/calculatorpg", params="bh", method = RequestMethod.POST)
    public String binaryToHex(@ModelAttribute("operationModel")  OperationModel operationModel, Model model ){
        if(program.isbinary(operationModel) == true){
            model.addAttribute("resultb", program.binaryToHex(operationModel));
        }else {
            model.addAttribute("resultb","No es un numero binario");
        }
        return "calculator";
    }

    @RequestMapping(value="/calculatorpg", params="db", method = RequestMethod.POST)
    public String decimalToBin(@ModelAttribute("operationModel")  OperationModel operationModel, Model model ){
        model.addAttribute("resultd", program.decimalToBin(operationModel));
        return "calculator";
    }

    @RequestMapping(value="/calculatorpg", params="do", method = RequestMethod.POST)
    public String decimalToOct(@ModelAttribute("operationModel")  OperationModel operationModel, Model model ){
        model.addAttribute("resultd", program.decimalToOct(operationModel));
        return "calculator";
    }

    @RequestMapping(value="/calculatorpg", params="dh", method = RequestMethod.POST)
    public String decimalToHex(@ModelAttribute("operationModel")  OperationModel operationModel, Model model ){
        model.addAttribute("resultd", program.decimalToHex(operationModel));
        return "calculator";
    }

    @RequestMapping(value="/calculatorpg", params="hb", method = RequestMethod.POST)
    public String hexToBin(@ModelAttribute("operationModel")  OperationModel operationModel, Model model ){
        model.addAttribute("resulth", program.hexToBinary(operationModel));
        return "calculator";
    }

    @RequestMapping(value="/calculatorpg", params="ho", method = RequestMethod.POST)
    public String hexToOct(@ModelAttribute("operationModel")  OperationModel operationModel, Model model ){
        model.addAttribute("resulth", program.hexToOctal(operationModel));
        return "calculator";
    }

    @RequestMapping(value="/calculatorpg", params="hd", method = RequestMethod.POST)
    public String hexToDecimal(@ModelAttribute("operationModel")  OperationModel operationModel, Model model ){
        model.addAttribute("resulth", program.hexToDecimal(operationModel));
        return "calculator";
    }

    @RequestMapping(value="/calculatorpg", params="ob", method = RequestMethod.POST)
    public String octalToBin(@ModelAttribute("operationModel")  OperationModel operationModel, Model model ){
        model.addAttribute("resulto", program.octalToBinary(operationModel));
        return "calculator";
    }

    @RequestMapping(value="/calculatorpg", params="od", method = RequestMethod.POST)
    public String octalToDecimal(@ModelAttribute("operationModel")  OperationModel operationModel, Model model ){
        model.addAttribute("resulto", program.octalToDecimal(operationModel));
        return "calculator";
    }

    @RequestMapping(value="/calculatorpg", params="oh", method = RequestMethod.POST)
    public String octalToHex(@ModelAttribute("operationModel")  OperationModel operationModel, Model model ){
        model.addAttribute("resulto", program.octalToHex(operationModel));
        return "calculator";
    }
}

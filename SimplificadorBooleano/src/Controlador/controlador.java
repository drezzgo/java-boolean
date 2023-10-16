package Controlador;

import Modelo.BoolSolver;
import Vista.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class controlador implements ActionListener {
    
    private Frame objf;
    private BoolSolver solver;
    private String expresion;
    
    public controlador() {
        this.objf = new Frame();
        this.solver = new BoolSolver();
    }
    
    public controlador(Frame objf, BoolSolver solver) {
        this.objf = objf;
        this.solver = solver;
    }
    
    public void iniciar() {
        objf.getBtnSimplificar().addActionListener(this);
        objf.getBtnClear().addActionListener(this);
        objf.setLocationRelativeTo(null);
        objf.setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(objf.getBtnSimplificar())) {
            expresion = objf.getTxtExpresion().getText();
            solver.eval(expresion);
            objf.getTxtaExpresionSimplificada().append("EXPRESION ORIGINAL : " + expresion + "\n");
            String f = solver.truthTableToString();
            objf.getTxtaTablaDeVerdad().append(f);
            objf.getTxtaExpresionSimplificada().append("EXPRESION SIMPLIFICADA : "+solver.simplify()+"\n");
        }
        if(e.getSource().equals(objf.getBtnClear())){
            objf.getTxtExpresion().setText("");
            objf.getTxtaExpresionSimplificada().setText("");
            objf.getTxtaTablaDeVerdad().setText("");
        }
    }
    
}

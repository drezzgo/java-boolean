package Modelo;

import java.io.*;
import java.util.*;

public class BoolSolver {
    // Lista de tokens:
    private ArrayList<Token> listaDeTokens;
    private ArrayList<Token> rpn;
    private ArrayList<Integer> minterminos;
    private ArrayList<Integer> maxterminos;
    // Cantidad de variables en la lista:
    private Integer cantidadDeVariables;
    // Apunta a los tokens con las variables:
    private ArrayList<Token> variables;
    // La expresión original se almacena aquí:
    private String expresion;

    // Tabla de verdad (solo la columna de salida)
    public BoolSolver(String expresion) {
        inicializar(expresion);
        evaluar();
    }

    public BoolSolver(String expresion, String nombreArchivo) {
        inicializar(expresion);
        evaluar(expresion, nombreArchivo);
    }

    public BoolSolver() {
        // Literalmente no hay nada que hacer aquí.
    }

    public void imprimirLista() {
        for (Token token : listaDeTokens) {
            System.out.println(token.getValue() + " : " + token.getType() + " : En: " + token.getPosition());
        }
    }

    public ArrayList<Token> getLista() {
        return this.listaDeTokens;
    }

    private String getExpresion() {
        return this.expresion;
    }

    private void setExpresion(String expresion) {
        this.expresion = expresion;
    }

    private void setLista(ArrayList<Token> tokens) {
        this.listaDeTokens = tokens;
    }

    // Consumir una variable:
    private int consumirVariable(String expresion, int posicion) {
        Integer salto = posicion;
        Integer posicionVariable = this.getCantidadDeVariables();
        Token temporal = null;
        Boolean existe = false;
        for (Integer itr = posicion; (expresion.length() != itr) && (Character.isLetter(expresion.charAt(itr)) || (expresion.charAt(itr) == '_') || (Character.isDigit(expresion.charAt(itr))); itr++) {
            salto++;
        }
        String temp = expresion.substring(posicion, salto);
        for (Token tok : getLista()) {
            if (temp.equals(tok.getValue())) {
                posicionVariable = ((OperandToken) tok).getVariablePosition();
                existe = true;
            }
        }
        temporal = new OperandToken(TokenType.VARIABLE, temp, posicion, posicionVariable);
        if (existe) {
            getLista().add(temporal);
            return salto - 1;
        } else {
            // La variable aún no está en la lista, por lo tanto la agregamos
            getVariables().add(temporal);
        }
        getLista().add(temporal);
        // Incrementar cantidadDeVariables:
        setCantidadDeVariables(getCantidadDeVariables() + 1);
        return salto - 1;
    }

    // Consumir un literal:
    private void consumirLiteral(Character digito, TokenType tipo, Integer posicion) {
        getLista().add(new OperandToken(tipo, Character.toString(digito), posicion));
    }

    private Boolean consumirLargo(String expresion, String coincidencia, TokenType tipo, Integer posicion) {
        // Utilizar una simple anticipación de 1 caracter:
        if (posicion == (expresion.length() - coincidencia.length())) {
            // La anticipación simplemente no es posible, ya que no hay más caracteres en la cadena de expresión,
            // por lo tanto, simplemente retornamos false aquí.
            return false;
        } else {
            if (coincidencia.equals(expresion.substring(posicion, coincidencia.length() - 1))) {
                // Coincide, por lo tanto, podemos crear el token y continuar con nuestro día:
                // TODO: si planeo implementar completamente este método en el futuro, entonces debo implementar el proceso de creación de tokens / inserción de tokens aquí y agregar un nuevo tipo de token al enum TokenType.
                return true;
            } else {
                // No coincide:
                return false;
            }
        }
    }

    private void consumir(Character digito, TokenType tipo, Integer posicion) {
        listaDeTokens.add(new OperatorToken(tipo, Character.toString(digito), posicion));
    }

    private Boolean tokenizar() {
        setLista(new ArrayList<Token>(32));
        int longitud = expresion.length();
        Boolean error = false;
        for (int i = 0; i < longitud; i++) {
            switch (expresion.charAt(i)) {
                case '1':
                case '0':
                    // Literal lógico '1'
                    consumirLiteral(expresion.charAt(i), TokenType.LITERAL, i);
                    break;
                case '&':
                case '*':
                    consumir(expresion.charAt(i), TokenType.AND, i);
                    break;
                case '|':
                case '+':
                    consumir(expresion.charAt(i), TokenType.OR, i);
                    break;
                case '!':
                case '-':
                    consumir(expresion.charAt(i), TokenType.NOT, i);
                    break;
                case '(':
                case '[':
                case '{':
                    consumir(expresion.charAt(i), TokenType.LPAREN, i);
                    break;
                case ')':
                case '}':
                case ']':
                    consumir(expresion.charAt(i), TokenType.RPAREN, i);
                    break;
                case ' ':
                case '\r':
                case '\n':
                    // Saltar este carácter, ya que es solo un delimitador.
                    continue;
                case '_':
                    i = consumirVariable(expresion, i);
                    break;
                default:
                    if ((Character.isLetter(expresion.charAt(i))) {
                        // Comprobar si el carácter actual es una letra del alfabeto:
                        i = consumirVariable(expresion, i);
                    } else {
                        // ¡Este no es un token válido!
                        String mensajeError = new String("Token ilegal: " + expresion.charAt(i) + " en: " + i);
                        System.out.println(mensajeError);
                        error = true;
                    }
                    break;
            }
        }
        return error;
    }

    /**
     * Implementación simple de la operación de la "shunting-yard", que convierte una expresión booleana en notación infija
     * en notación polaca inversa o postfija.
     */
    private void infijoAPostfijo() {
        ArrayList<Token> salida = new ArrayList<>();
        Stack<Token> pila = new Stack<>();

        if (expresion.length() == 0) return;

        for (Token tok : getLista()) {
            if (tok.getType().isBinaryOperator()) {
                // Operador:
                while (!pila.isEmpty() && (!pila.peek().getType().isParen() && ((OperatorToken) tok).isHigherPrecedenceThan((OperatorToken) pila.peek()))) {
                    Token temp = pila.pop();
                    salida.add(temp);
                }
                pila.push(tok);
            } else if (tok.getType().isUnaryOperator()) {
                pila.push(tok);
            } else if (tok.getType().isLeftParen()) {
                pila.push(tok);
            } else if (tok.getType().isRightParen()) {
                // Derecho de parentesis:
                while (!pila.isEmpty() && (!pila.peek().getType().isLeftParen())) {
                    Token temp = pila.pop();
                    salida.add(temp);
                }
                // Pop de la pila el paréntesis izquierdo:
                if (!pila.isEmpty() && (pila.peek().getType().isLeftParen())) {
                    pila.pop();
                }
            } else {
                // Operandos:
                salida.add(tok);
            }
        }

        // Pop the rest of the operators from the stack to the output
        while (!pila.isEmpty()) {
            Token temp = pila.pop();
            salida.add(temp);
        }

        rpn = salida;
    }

    /**
     * Resuelve la tabla de verdad.
     */
    public void evaluar() {
        ArrayList<Integer> casos = new ArrayList<>();
        rpn = new ArrayList<>();
        ArrayList<Token> variables = new ArrayList<>();
        Stack<Token> tokens = new Stack<>();
        Set<TokenType> operadores = TokenType.getOperadores();
        // Almacena los valores (True/False) para las variables
        ArrayList<Integer> valores = new ArrayList<>();

        for (Token token : listaDeTokens) {
            if (token.getType().isVariable()) {
                variables.add(token);
            }
        }

        // Generar todos los casos posibles para las variables
        int totalCombinaciones = (int) Math.pow(2, variables.size());
        for (int i = 0; i < totalCombinaciones; i++) {
            int binario = i;
            for (Token variable : variables) {
                valores.add(binario % 2);
                binario /= 2;
            }
            casos.add(calcularExpresionConValores(valores) ? 1 : 0);
            valores.clear();
        }

        minterminos = new ArrayList<>();
        maxterminos = new ArrayList<>();

        for (int i = 0; i < casos.size(); i++) {
            if (casos.get(i) == 1) {
                minterminos.add(i);
            } else {
                maxterminos.add(i);
            }
        }
    }

    public void evaluar(String expresion, String archivo) {
        setExpresion(expresion);
        Boolean hayError = tokenizar();
        if (hayError) {
            System.out.println("La expresión no se pudo tokenizar correctamente.");
            return;
        }
        infijoAPostfijo();
        evaluar();
    }

    // Esta función evalúa una expresión booleana utilizando los valores proporcionados para las variables.
    private Boolean calcularExpresionConValores(ArrayList<Integer> valores) {
        // El algoritmo RPN evalúa una expresión booleana en notación RPN
        // utilizando una pila para realizar el cálculo.
        Stack<Boolean> pila = new Stack<>();
        for (Token token : rpn) {
            if (token.getType().isLiteral()) {
                pila.push(((OperandToken) token).isTrue());
            } else if (token.getType().isVariable()) {
                int variablePosition = ((OperandToken) token).getVariablePosition();
                pila.push(valores.get(variablePosition) == 1);
            } else if (token.getType().isBinaryOperator()) {
                boolean operand2 = pila.pop();
                boolean operand1 = pila.pop();
                if (token.getType() == TokenType.AND) {
                    pila.push(operand1 && operand2);
                } else if (token.getType() == TokenType.OR) {
                    pila.push(operand1 || operand2);
                }
            } else if (token.getType().isUnaryOperator()) {
                boolean operand = pila.pop();
                pila.push(!operand);
            }
        }
        // El resultado final se encuentra en la cima de la pila
        return pila.peek();
    }

    public ArrayList<Integer> getMinterminos() {
        return minterminos;
    }

    public ArrayList<Integer> getMaxterminos() {
        return maxterminos;
    }

    public ArrayList<Token> getVariables() {
        if (variables == null) {
            variables = new ArrayList<>();
        }
        return variables;
    }

    private void inicializar(String expresion) {
        setExpresion(expresion);
        this.setCantidadDeVariables(0);
        // Tokeniza la expresión, luego convierte de infijo a posfijo y evalúa
        Boolean hayError = tokenizar();
        if (hayError) {
            System.out.println("La expresión no se pudo tokenizar correctamente.");
            return;
        }
        infijoAPostfijo();
    }

    private Integer getCantidadDeVariables() {
        if (this.cantidadDeVariables == null) {
            this.cantidadDeVariables = 0;
        }
        return this.cantidadDeVariables;
    }

    private void setCantidadDeVariables(Integer cantidadDeVariables) {
        this.cantidadDeVariables = cantidadDeVariables;
    }
}

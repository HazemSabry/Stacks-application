package src;
/**
 * @author <a href="https://github.com/HazemSabry/Stacks-application" target="_blank">Hazem Sabry</a>
 */
public interface IPostfix {
    /**
    * Takes a symbolic/numeric infix expression as input and converts it to
    * postfix notation. There is no assumption on spaces between terms or the
    * length of the term (e.g., two digits symbolic or numeric term)
    *
    * @param expression infix expression
    * @return postfix expression
     * @throws Exception
    */

    public String infixToPostfix(String expression) throws Exception;


    /**
    * Evaluate a postfix numeric expression, with a single space separator
    * @param expression postfix expression
    * @return the expression evaluated value
    */

    public int evaluate(String expression);

}

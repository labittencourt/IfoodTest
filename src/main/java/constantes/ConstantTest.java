package constantes;

import java.util.stream.IntStream;

import static java.util.stream.IntStream.concat;
import static org.apache.commons.lang3.StringUtils.join;

public class ConstantTest {

    public static final String EMAIL_INVALIDO = "primeiro@teste.com";
    public static final String SENHA_INVALIDO = "0987666";
    public static final String EMAIL_VALIDO = "teste@teste.com";
    public static final String SENHA_VALIDO = "123456";

    public static final String CODIGO_CAD_VALIDO = "123000";
    public static final String NOME_CAD_VALIDO = "MANUELA";

    public static final String VALIDAR_CADASTRO = CODIGO_CAD_VALIDO + " - " + NOME_CAD_VALIDO;
}
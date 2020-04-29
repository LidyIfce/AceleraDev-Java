package challenge;

public class CriptografiaCesariana implements Criptografia {

    @Override
    public String criptografar(String texto) {
        if(texto.isEmpty()){
            throw new IllegalArgumentException();
        }
        String textoLowercase = texto.toLowerCase();
        char auxChar;
        String stringCriptografada = "";

        for (int i = 0; i < texto.length(); i++) {
            auxChar = textoLowercase.charAt(i);
            if (Character.isLetter(auxChar)) {
                auxChar += 3;
                if (auxChar > 'z') {
                    auxChar -= 26;
                }
            }
            stringCriptografada += auxChar;
        }
        return stringCriptografada;
    }

    @Override
    public String descriptografar(String texto) {
        if(texto.isEmpty()){
            throw new IllegalArgumentException();
        }
        String textoLowercase = texto.toLowerCase();
        char auxChar;
        String stringDesciptografada = "";

        for (int i = 0; i < texto.length(); i++) {
            auxChar = textoLowercase.charAt(i);
            if (Character.isLetter(auxChar)) {
                auxChar -= 3;
                if (auxChar < 'a') {
                    auxChar += 26;
                }
            }
            stringDesciptografada += auxChar;
        }
        return stringDesciptografada;
    }
}


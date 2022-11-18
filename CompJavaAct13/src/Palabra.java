public class Palabra
{
    private final String palabra;
    private final int longitud;

    public Palabra(String palabra)
    {
        this.palabra = palabra;
        this.longitud = palabra.length();
    }

    public String getPalabra() {
        return palabra;
    }

    public int getLongitud() {
        return longitud;
    }
}

package problemHotel.exceptions;
//Usando o RuntimeException, pois não é obrigatório propagar esta exceção
public class DomainException extends RuntimeException {
    private static final long serialVersionUID = 1L;
    
    public DomainException(String msg){
        super(msg);
    }
}

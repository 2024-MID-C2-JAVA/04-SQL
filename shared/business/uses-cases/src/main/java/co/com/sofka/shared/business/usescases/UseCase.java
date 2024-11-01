package co.com.sofka.shared.business.usescases;

public interface UseCase<RequestType, ResponseType> {
    public ResponseType execute(RequestType request);
}

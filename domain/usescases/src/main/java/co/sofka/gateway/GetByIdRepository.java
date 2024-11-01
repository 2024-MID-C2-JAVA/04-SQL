package co.sofka.gateway;

public interface GetByIdRepository <T>{
    T getById(T t);
}

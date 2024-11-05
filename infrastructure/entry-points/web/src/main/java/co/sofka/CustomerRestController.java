package co.sofka;

import co.sofka.data.customer.CreateCustomerDTO;
import co.sofka.data.customer.CustomerResponseDTO;
import co.sofka.data.customer.DeleteCustomerDTO;
import co.sofka.data.customer.GetCustomerByIdDTO;
import co.sofka.handler.CustomerHandler;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/customer")
public class CustomerRestController {

    private final CustomerHandler customerHandler;

    public CustomerRestController(CustomerHandler customerHandler) {
        this.customerHandler = customerHandler;
    }

    @PostMapping("/create")
    public ResponseEntity<String> createCustomer(@RequestBody CreateCustomerDTO createCustomerDTO) {
        try{
            customerHandler.createCustomer(createCustomerDTO);
            System.out.println("Customer name: "+createCustomerDTO.getName());
            return ResponseEntity.ok("Customer created");
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred while creating the customer: "+e.getMessage());
        }
    }

    @PostMapping("/delete")
    public ResponseEntity<String> deleteCustomer(@RequestBody DeleteCustomerDTO deleteCustomerDTO) {
        try{
            customerHandler.deleteCustomer(deleteCustomerDTO);
            return ResponseEntity.ok("Customer deleted");
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred while deleting the customer: "+e.getMessage());
        }
    }

    @PostMapping("/get")
    public ResponseEntity<CustomerResponseDTO> getCustomerById(@RequestBody GetCustomerByIdDTO dto){
        try{
            return ResponseEntity.ok(customerHandler.getCustomerById(dto));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

}

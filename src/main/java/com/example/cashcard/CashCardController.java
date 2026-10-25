package com.example.cashcard;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Optional;

@RestController
@RequestMapping("/cashcards")
public class CashCardController {

    private CashCardRepository  cashCardRepository ;
    private CashCardController(CashCardRepository cashCardRepository){
        this.cashCardRepository = cashCardRepository ;
    }
    
    @GetMapping("/{requestedId}")
    private ResponseEntity<CashCard>
     findById(@PathVariable Long requestedId) {

        Optional<CashCard> cashCaedOptional = 
        cashCardRepository.findById(requestedId);

        if (cashCaedOptional.isPresent()){
        
            return ResponseEntity.ok(cashCaedOptional.get());
        } else {
            return ResponseEntity.notFound().build();
        }
       
        
    }
        
}



package com.example.librarymangesystem.service;



import com.example.librarymangesystem.model.Borrower;
import com.example.librarymangesystem.repository.BorrowerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BorrowerService {

    @Autowired
    private BorrowerRepository borrowerRepository;

    public List<Borrower> getAllBorrowers() {
        return borrowerRepository.findAll();
    }

    public Optional<Borrower> getBorrowerById(Long id) {
        return borrowerRepository.findById(id);
    }

    public Borrower createBorrower(Borrower borrower) {
        return borrowerRepository.save(borrower);
    }

    public Borrower updateBorrower(Long id, Borrower borrower) {
        if (borrowerRepository.existsById(id)) {
            borrower.setId(id);
            return borrowerRepository.save(borrower);
        }
        return null;
    }

    public boolean deleteBorrower(Long id) {
        if (borrowerRepository.existsById(id)) {
            borrowerRepository.deleteById(id);
            return true;
        }
        return false;
    }
}

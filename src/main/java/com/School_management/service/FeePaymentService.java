package com.School_management.service;

import com.School_management.entity.FeePayment;
import com.School_management.exception.UserNotFoundException;
import com.School_management.repository.FeePaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FeePaymentService {
    @Autowired
    private FeePaymentRepository feePaymentRepository;

    public FeePayment saveFeePayment(FeePayment feePayment) {
        return feePaymentRepository.save(feePayment);
    }

    public FeePayment findById(int id) {
        return feePaymentRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("FeePayment not found with ID :" + id));
    }

    //    public Fee_payment findById(int id) {
//        try {
//            return fee_paymentRepository.findById(id).orElseThrow();
//        } catch (Exception e) {
//            throw new RuntimeException("Fee_payment not found with ID: " + id, e);
//        }
//    }
    public List<FeePayment> getAllFeePayment() {
        return feePaymentRepository.findAll();
    }

    public String deleteById(int id) {
        if (feePaymentRepository.existsById(id)) {
            feePaymentRepository.deleteById(id);
            return "FeePayment deleted with ID: " + id;
        } else {
            throw new UserNotFoundException("FeePayment not found with ID: " + id);
        }
    }

    public FeePayment updateById(final FeePayment feePayment, final Integer id) {
        final Optional<FeePayment> feePaymentOptional = this.feePaymentRepository.findById(id);
        if (feePaymentOptional.isEmpty()) {
            throw new UserNotFoundException("FeePayment not Found.");
        }
        final FeePayment feePaymentObject = feePaymentOptional.get();
        if (feePayment.getDate() != null) {
            feePaymentObject.setDate(feePayment.getDate());
        }
        if (feePayment.getFeeAmount() != 0) {
            feePaymentObject.setFeeAmount(feePayment.getFeeAmount());
        }
        if (feePayment.getAstatus() != null) {
            feePaymentObject.setAstatus(feePayment.getAstatus());
        }
        if (feePayment.getTerm() != null) {
            feePaymentObject.setTerm(feePayment.getTerm());
        }

        return feePaymentRepository.save(feePaymentObject);
    }

}


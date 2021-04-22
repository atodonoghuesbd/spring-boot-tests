package com.example.springboottests.service.data;

import com.example.springboottests.model.persistence.WalletEntity;
import com.example.springboottests.repository.WalletRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WalletService {
    private final WalletRepository walletRepository;
    @Autowired
    public WalletService(WalletRepository walletRepository) {
        this.walletRepository = walletRepository;
    }

    public WalletEntity save(WalletEntity walletEntity) {
        return walletRepository.save(walletEntity);
    }
}

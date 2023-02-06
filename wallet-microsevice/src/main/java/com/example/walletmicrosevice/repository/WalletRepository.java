package com.example.walletmicrosevice.repository;


import com.example.walletmicrosevice.entity.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface WalletRepository extends JpaRepository<Wallet,Long> {

    Optional<Wallet> findWalletByReferenceWallet(String referenceWallet);

    Optional<Wallet> findWalletByOwner(String owner);
}

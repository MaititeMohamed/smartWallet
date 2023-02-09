package com.example.walletmicroservice.repository;


import com.example.walletmicroservice.entity.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface WalletRepository extends JpaRepository<Wallet,Long> {

    Optional<Wallet> findWalletByReferenceWallet(String referenceWallet);

    Optional<Wallet> findWalletByOwnerCin(String ownerCin);
}

package org.example;

public interface OwnerService {

    List<Owner> findAll();

    Owner findById(int theId);

    Owner save(Owner theOwner);

    void deleteById(int theId);
}

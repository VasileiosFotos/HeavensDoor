package org.example;

import java.util.List;

public class OwnerServiceImp implements OwnerService
{
    @Autowired
    public OwnerServiceImp(OwnerRepository theOwnerRepository) {
        ownerRepository = theOwnerRepository;
    }

    @Override
    public List<Owner> findAll() {
        return ownerRepository.findAllByOrderByLastNameAsc();
    }

    @Override
    public Owner findById(int theId) {
        Optional<Owner> result = ownerRepository.findById(theId);

        Owner theOwner = null;

        if (result.isPresent()) {
            theOwner = result.get();
        }
        else {

            throw new RuntimeException("Did not find owner id - " + theId);
        }

        return theOwner;
    }

    @Override
    public Owner save(Owner theOwner) {
        return ownerRepository.save(theOwner);
    }

    @Override
    public void deleteById(int theId) {
        ownerRepository.deleteById(theId);
    }
}

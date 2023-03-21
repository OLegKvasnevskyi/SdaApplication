package net.javaguides.sms.service.impl;

import net.javaguides.sms.entity.Organization;
import net.javaguides.sms.repository.OrganizationRepository;
import net.javaguides.sms.service.OrganizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrganizationServiceImpl implements OrganizationService {

    private OrganizationRepository organizationRepository;

    @Autowired
    public OrganizationServiceImpl(OrganizationRepository organizationRepository) {
        this.organizationRepository = organizationRepository;
    }


    @Override
    public List<Organization> getAllOrganizations() {
        return organizationRepository.findAll();
    }


    @Override
    public Organization getOrganizationById(Integer id) {
        return organizationRepository.findById(id).get();
    }

    @Override
    public Organization updateOrganization(Organization organization) {
        return organizationRepository.save(organization);
    }


    @Override
    public void deleteOrganizationById(Integer id) {
        organizationRepository.deleteById(id);
    }


    @Override
    public Organization saveOrganization(Organization organization) {
        return organizationRepository.save(organization);
    }


}








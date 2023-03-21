package net.javaguides.sms.service;

import net.javaguides.sms.entity.Organization;

import java.util.List;

public interface OrganizationService {
    List<Organization> getAllOrganizations();

    Organization saveOrganization(Organization organization);

    Organization getOrganizationById(Integer id);

    Organization updateOrganization(Organization organization);

    void deleteOrganizationById(Integer id);
}

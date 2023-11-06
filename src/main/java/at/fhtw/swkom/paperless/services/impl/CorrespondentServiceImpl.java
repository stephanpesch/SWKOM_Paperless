package at.fhtw.swkom.paperless.services.impl;

import at.fhtw.swkom.paperless.persistance.repositories.CorrespondentRepository;
import at.fhtw.swkom.paperless.services.mapper.CorrespondentMapper;
import at.fhtw.swkom.paperless.services.mapper.CorrespondentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public abstract class CorrespondentServiceImpl implements CorrespondentService {

    @Autowired
    private CorrespondentRepository correspondentRepository;

    @Autowired
    private CorrespondentMapper correspondentMapper;




}

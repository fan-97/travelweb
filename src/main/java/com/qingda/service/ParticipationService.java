package com.qingda.service;

import com.qingda.dao.ParticipationDao;
import com.qingda.domain.Participation;

import java.util.List;

public class ParticipationService {

    private ParticipationDao participationDao = new ParticipationDao();

    public List<Participation> findparticipationByName(String username) {
        return participationDao.findparticipationByName(username);
    }

    public Participation join(Participation participation) {
        return participationDao.insert(participation);
    }

    public void canceParticipation(String p_id) {
        participationDao.delete(p_id);
    }

    public Participation findById(String id) {
        return participationDao.findById(id);
    }

    public void update(Participation participation) {
        participationDao.update(participation);
    }

}

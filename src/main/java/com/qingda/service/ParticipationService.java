package com.qingda.service;

import com.qingda.dao.ParticipationDao;
import com.qingda.domain.Participation;

import java.util.List;

public class ParticipationService {
    public List<Participation> findparticipationByName(String username) {
        ParticipationDao participationDao = new ParticipationDao();
        return participationDao.findparticipationByName(username);
    }

    public void join(String l_theme, String u_name) {
        ParticipationDao participationDao = new ParticipationDao();
        participationDao.join(l_theme,u_name);
    }

    public void canceParticipation(String l_id) {
        ParticipationDao participationDao = new ParticipationDao();
        participationDao.canceParticipation(l_id);
    }
}

package com.esprit.examen.services;

import java.util.List;

import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esprit.examen.entities.Facture;
import com.esprit.examen.repositories.FactureRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@Transactional
public class FactureServiceImpl implements IFactureService {

	@Autowired
	FactureRepository factureRepository;

	
	@Override
	public List<Facture> retrieveAllFactures() {
		List<Facture> factures = factureRepository.findAll();
		for (Facture facture : factures) {
			log.info(" facture : " + facture);
		}
		return factures;
	}

	
	public Facture addFacture(Facture f) {
	 factureRepository.save(f);
	 return f;
	}



	@Override
	public void deleteFacture(Long id) {
		factureRepository.deleteById(id);
	}


	@Override
	public Facture retrieveFacture(Long factureId) {

		return factureRepository.findById(factureId).orElse(null);
	}
	@Override
	public Facture updateFacture(Facture o) {
		factureRepository.save(o);
		return o;
	}
}


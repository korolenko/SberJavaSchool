package FinalProject.Services;

import FinalProject.Entities.LinksEntity;
import FinalProject.Repositories.LinksRepository;
import FinalProject.dto.LinksDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class LinksService {

    @Autowired
    private LinksRepository linksRepository;

    public LinksEntity findById(Long id){
        return linksRepository.getOne(id);
    }

    public LinksEntity create(LinksDto linksDto){
        LinksEntity  linksEntity = new LinksEntity(linksDto.getBrand(), linksDto.getModel(), linksDto.getSparepart());
        return linksRepository.save(linksEntity);
    }

    public void delete(Long id){
        linksRepository.delete(linksRepository.getOne(id));
    }

    public  LinksEntity update(LinksDto linksDto){
        LinksEntity linksEntity = linksRepository.getOne(linksDto.getId());
        linksEntity.setBrand(linksDto.getBrand());
        linksEntity.setModel(linksDto.getModel());
        linksEntity.setSparePart(linksDto.getSparepart());
        return linksRepository.save(linksEntity);
    }
}

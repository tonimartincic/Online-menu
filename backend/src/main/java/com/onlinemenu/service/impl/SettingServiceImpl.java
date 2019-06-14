package com.onlinemenu.service.impl;

import com.onlinemenu.domain.setting.Setting;
import com.onlinemenu.repository.SettingRepository;
import com.onlinemenu.service.SettingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SettingServiceImpl implements SettingService {

  private SettingRepository settingRepository;

  @Autowired
  public SettingServiceImpl(SettingRepository settingRepository) {
    this.settingRepository = settingRepository;
  }

  @Override
  public List<Setting> getAll() {
    return settingRepository.findAll();
  }

  @Override
  public Setting get(Long id) {
    return settingRepository.getOne(id);
  }

  @Override
  public Setting create(Setting setting) {
    return settingRepository.save(setting);
  }

  @Override
  public Setting update(Setting setting) {
    return settingRepository.save(setting);
  }

  @Override
  public void delete(Long id) {
    settingRepository.deleteById(id);
  }
}

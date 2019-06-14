package com.onlinemenu.service;

import com.onlinemenu.domain.setting.Setting;

import java.util.List;

public interface SettingService {

  List<Setting> getAll();

  Setting get(Long id);

  Setting create(Setting setting);

  Setting update(Setting setting);

  void delete(Long id);
}

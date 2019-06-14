package com.onlinemenu.controller;

import com.onlinemenu.domain.setting.Setting;
import com.onlinemenu.service.SettingService;
import org.apache.commons.lang.NullArgumentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SettingController {

  private final SettingService settingService;

  @Autowired
  public SettingController(final SettingService settingService) {
    this.settingService = settingService;
  }

  @GetMapping("/api/settings")
  public List<Setting> getAll() {
    return this.settingService.getAll();
  }

  @GetMapping("/api/settings/{id}")
  public Setting get(@PathVariable final Long id) {
    return this.settingService.get(id);
  }

  @PostMapping("/api/settings")
  public Setting create(@RequestBody final Setting setting) {
    if (setting == null) {
      throw new NullArgumentException("Request body cannot be null");
    }

    return this.settingService.create(setting);
  }

  @PutMapping("/api/settings")
  public Setting update(@RequestBody final Setting setting) {
    if (setting == null) {
      throw new NullArgumentException("Request body cannot be null");
    }

    return this.settingService.update(setting);
  }

  @DeleteMapping("/api/settings/{id}")
  public void delete(@PathVariable final Long id) {
    this.settingService.delete(id);
  }
}

package com.tavisca.gce.tirctc.models.dao;

import java.util.List;

public interface DataPersister {
  void save(Object object);
  void delete(Object object);
  List findAll();
}

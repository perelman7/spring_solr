1) Создать core для хранения данных
solr create -c corename -p port

2) Настроить схему для созданого core
3) Добавить jdbc-driver (postgresql-42.2.0.jar) в {SOLR_HOME}/contrib/dataimporthandler/lib/
4) Внести правки в файлы конфигураций и создание файла для соединения к data source
5) Перезапустить solr
solr restart -p port

6) Запустить выгрузку данных
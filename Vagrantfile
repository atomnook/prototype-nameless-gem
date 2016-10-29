# -*- mode: ruby -*-
# vi: set ft=ruby :

Vagrant.configure(2) do |config|
  config.vm.box = "centos/7"
  config.vm.network "private_network", ip: "192.168.33.10"

  config.vm.provider "virtualbox" do |v|
    v.memory = 1024
  end

  config.vm.provision "docker" do |d|
    d.pull_images "mariadb:10.1.18"
    d.pull_images "redis:3.2.4"
  end

  config.vm.provision "shell", inline: "docker ps -aq | xargs -r docker stop | xargs -r docker rm"

  config.vm.provision "docker" do |d|
    d.run "mariadb",
      image: "mariadb:10.1.18",
      args: "-v /vagrant/vagrant/mariadb:/docker-entrypoint-initdb.d -p 3306:3306 -e MYSQL_ROOT_PASSWORD=root"
  end

  config.vm.provision "docker" do |d|
    d.run "redis6379",
      image: "redis:3.2.4",
      args: "--net host -v /vagrant/vagrant/redis/6379:/data/conf",
      cmd: "redis-server /data/conf/redis.conf"

    d.run "redis6380",
      image: "redis:3.2.4",
      args: "--net host -v /vagrant/vagrant/redis/6380:/data/conf",
      cmd: "redis-server /data/conf/redis.conf"

    d.run "redis6381",
      image: "redis:3.2.4",
      args: "--net host -v /vagrant/vagrant/redis/6381:/data/conf",
      cmd: "redis-server /data/conf/redis.conf"
  end

  config.vm.provision "shell", inline: "docker exec redis6379 redis-cli -p 6379 cluster addslots {0..5500}"
  config.vm.provision "shell", inline: "docker exec redis6380 redis-cli -p 6380 cluster addslots {5501..11000}"
  config.vm.provision "shell", inline: "docker exec redis6381 redis-cli -p 6381 cluster addslots {11001..16383}"

  config.vm.provision "shell", inline: "docker exec redis6380 redis-cli -p 6380 cluster meet 192.168.33.10 6379"
  config.vm.provision "shell", inline: "docker exec redis6381 redis-cli -p 6381 cluster meet 192.168.33.10 6379"
end

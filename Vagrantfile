# -*- mode: ruby -*-
# vi: set ft=ruby :

Vagrant.configure(2) do |config|
  config.vm.box = "centos/7"
  config.vm.network "private_network", ip: "192.168.33.10"

  config.vm.provider "virtualbox" do |v|
    v.memory = 1024
  end

  config.vm.provision "file", source: "vagrant", destination: "/home/vagrant/"

  config.vm.provision "docker" do |d|
    d.pull_images "mariadb:10.1.18"

    d.run "mariadb",
      image: "mariadb:10.1.18",
      args: "-v /home/vagrant/vagrant:/docker-entrypoint-initdb.d -p 3306:3306 -e MYSQL_ROOT_PASSWORD=root"
  end
end

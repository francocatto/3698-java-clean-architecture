package br.com.alura.codechella.infrastructure.persistence;

import org.springframework.data.repository.CrudRepository;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class UsuarioFileRepository implements CrudRepository<UsuarioEntity, Long> {
    private static final String FILE_PATH = "usuarios.ser";

    @Override
    public <S extends UsuarioEntity> S save(S entity) {
        List<UsuarioEntity> usuarios = (List<UsuarioEntity>) findAll();
        usuarios.add(entity);
        writeToFile(usuarios);
        return entity;
    }

    @Override
    public <S extends UsuarioEntity> Iterable<S> saveAll(Iterable<S> entities) {
        List<UsuarioEntity> usuarios = (List<UsuarioEntity>) findAll();
        entities.forEach(usuarios::add);
        writeToFile(usuarios);
        return entities;
    }

    @Override
    public Optional<UsuarioEntity> findById(Long id) {
        return ((List<UsuarioEntity>)findAll()).stream()
                .filter(usuario -> usuario.getId().equals(id))
                .findFirst();
    }

    @Override
    public boolean existsById(Long id) {
        return findById(id).isPresent();
    }

    @Override
    public Iterable<UsuarioEntity> findAll() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_PATH))) {
            return (List<UsuarioEntity>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            return new ArrayList<>();
        }
    }

    @Override
    public Iterable<UsuarioEntity> findAllById(Iterable<Long> ids) {
        List<UsuarioEntity> usuarios =  (List<UsuarioEntity>) findAll();
        List<UsuarioEntity> result = new ArrayList<>();
        for (Long id : ids) {
            findById(id).ifPresent(result::add);
        }
        return result;
    }

    @Override
    public long count() {
        return ((List<UsuarioEntity>)findAll()).size();
    }

    @Override
    public void deleteById(Long id) {
        List<UsuarioEntity> usuarios = (List<UsuarioEntity>) findAll();
        usuarios.removeIf(usuario -> usuario.getId().equals(id));
        writeToFile(usuarios);
    }

    @Override
    public void delete(UsuarioEntity entity) {
        deleteById(entity.getId());
    }

    @Override
    public void deleteAllById(Iterable<? extends Long> longs) {

    }

    @Override
    public void deleteAll(Iterable<? extends UsuarioEntity> entities) {
        List<UsuarioEntity> usuarios = (List<UsuarioEntity>) findAll();
        entities.forEach(usuarios::remove);
        writeToFile(usuarios);
    }

    @Override
    public void deleteAll() {
        writeToFile(new ArrayList<>());
    }

    private void writeToFile(List<UsuarioEntity> usuarios) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_PATH))) {
            oos.writeObject(usuarios);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<UsuarioEntity> findUsuarioEntityByCpf(String cpf) {
        return ((List<UsuarioEntity>)findAll()).stream().filter(usuario -> usuario.getCpf().equals(cpf)).collect(Collectors.toList());
    }
}

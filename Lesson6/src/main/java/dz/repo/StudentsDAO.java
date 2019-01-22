package dz.repo;

public interface StudentsDAO {

    int addRecord(String name, int score);

    int updateScore(String name, int score);

    int readScore(String name);
}

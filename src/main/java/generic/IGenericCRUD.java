package generic;

import java.util.List;

import com.challenge.dto.response.MessageResponseDTO;

public interface IGenericCRUD<T> {
	
	MessageResponseDTO insert(T cls);
	
	MessageResponseDTO update(Long id, T cls);
	
	void delete(Long id);
	
	T findById(Long id);
	
	List<T> findAll();
}

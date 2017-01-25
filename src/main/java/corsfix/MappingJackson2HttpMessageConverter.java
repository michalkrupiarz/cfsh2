package corsfix;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.hibernate4.Hibernate4Module;

public class MappingJackson2HttpMessageConverter extends ObjectMapper{
	public MappingJackson2HttpMessageConverter() {
		registerModule(new Hibernate4Module());
    }
}

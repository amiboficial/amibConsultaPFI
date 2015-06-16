package consultapfi

class Consulta {
	
	String mat
	String nom
	String apePat
	String apeMat
	String inst
	String fig
	String result
	String punt
	String fechaIn
	String fechaFi
	String mod

	static mapping ={
		
		table "consultap"
		
		mat column: 'matricula'
		nom column: 'nombre'
		apePat column: 'apepaterno'
		apeMat column: 'apematerno'
		inst column: 'institucion'
		fig column: 'figura'
		result column: 'resultado'
		punt column: 'puntaje'
		fechaIn column: 'fechainicio'
		fechaFi column: 'fechafin'
		mod column: 'modalidad'
		
		version false
		
	
	}
	
	
    static constraints = {
		
    }
}

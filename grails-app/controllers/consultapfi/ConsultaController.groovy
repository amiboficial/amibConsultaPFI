package consultapfi

import org.springframework.dao.DataIntegrityViolationException

class ConsultaController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list(Integer max) {
   
		
		def listaDeExamen = Consulta.findAll()
		
		
        [consultaInstanceList: listaDeExamen, consultaInstanceTotal: listaDeExamen.size()]
    }

    def create() {
        [consultaInstance: new Consulta(params)]
    }

    def save() {
        def consultaInstance = new Consulta(params)
        if (!consultaInstance.save(flush: true)) {
            render(view: "create", model: [consultaInstance: consultaInstance])
            return
        }

        flash.message = message(code: 'default.created.message', args: [message(code: 'consulta.label', default: 'Consulta'), consultaInstance.id])
        redirect(action: "show", id: consultaInstance.id)
    }

    def show(Long id) {
        def consultaInstance = Consulta.get(id)
        if (!consultaInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'consulta.label', default: 'Consulta'), id])
            redirect(action: "list")
            return
        }

        [consultaInstance: consultaInstance]
    }

    def edit(Long id) {
        def consultaInstance = Consulta.get(id)
        if (!consultaInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'consulta.label', default: 'Consulta'), id])
            redirect(action: "list")
            return
        }

        [consultaInstance: consultaInstance]
    }

    def update(Long id, Long version) {
        def consultaInstance = Consulta.get(id)
        if (!consultaInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'consulta.label', default: 'Consulta'), id])
            redirect(action: "list")
            return
        }

        if (version != null) {
            if (consultaInstance.version > version) {
                consultaInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'consulta.label', default: 'Consulta')] as Object[],
                          "Another user has updated this Consulta while you were editing")
                render(view: "edit", model: [consultaInstance: consultaInstance])
                return
            }
        }

        consultaInstance.properties = params

        if (!consultaInstance.save(flush: true)) {
            render(view: "edit", model: [consultaInstance: consultaInstance])
            return
        }

        flash.message = message(code: 'default.updated.message', args: [message(code: 'consulta.label', default: 'Consulta'), consultaInstance.id])
        redirect(action: "show", id: consultaInstance.id)
    }

    def delete(Long id) {
        def consultaInstance = Consulta.get(id)
        if (!consultaInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'consulta.label', default: 'Consulta'), id])
            redirect(action: "list")
            return
        }

        try {
            consultaInstance.delete(flush: true)
            flash.message = message(code: 'default.deleted.message', args: [message(code: 'consulta.label', default: 'Consulta'), id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
            flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'consulta.label', default: 'Consulta'), id])
            redirect(action: "show", id: id)
        }
    }
}

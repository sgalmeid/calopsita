package br.com.caelum.calopsita.controller;

import static br.com.caelum.vraptor.view.Results.logic;

import java.util.List;

import org.vraptor.annotations.InterceptedBy;

import br.com.caelum.calopsita.infra.interceptor.AuthorizationInterceptor;
import br.com.caelum.calopsita.model.PrioritizableCard;
import br.com.caelum.calopsita.model.Project;
import br.com.caelum.calopsita.repository.PrioritizationRepository;
import br.com.caelum.calopsita.repository.ProjectRepository;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;

@Resource
@InterceptedBy( { AuthorizationInterceptor.class })
public class PrioritizationController {

	private final PrioritizationRepository repository;
	private final ProjectRepository projectRepository;
	private final Result result;

	public PrioritizationController(Result result, PrioritizationRepository repository, ProjectRepository projectRepository) {
		this.result = result;
		this.repository = repository;
		this.projectRepository = projectRepository;
	}

	@Path("/projects/{project.id}/prioritization/") @Get
    public void prioritization(Project project) {
        result.include("project", this.projectRepository.get(project.getId()));
        result.include("cards", this.repository.listCards(project));
    }

	@Path("/projects/{project.id}/prioritize/") @Post
	public void prioritize(Project project, List<PrioritizableCard> cards) {
		for (PrioritizableCard card : cards) {
			PrioritizableCard loaded = repository.load(card);
			loaded.setPriority(card.getPriority());
		}
		prioritization(project);
		result.use(logic()).redirectTo(ProjectsController.class).cards(project);
	}

}

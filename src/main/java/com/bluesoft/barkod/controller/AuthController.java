package com.bluesoft.barkod.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.bluesoft.barkod.entity.Proje;
import com.bluesoft.barkod.entity.UserEntity;
import com.bluesoft.barkod.model.JwtAuthenticationRefreshDTO;
import com.bluesoft.barkod.model.JwtAuthenticationResponseDTO;
import com.bluesoft.barkod.model.LoginRequestDTO;
import com.bluesoft.barkod.security.JwtConfig;
import com.bluesoft.barkod.security.JwtTokenProvider;
import com.bluesoft.barkod.service.AkisService;
import com.bluesoft.barkod.service.ProjectService;
import com.bluesoft.barkod.service.UserService;
import com.bluesoft.barkod.service.Impl.AkisHavuzServiceImpl;

@CrossOrigin
@RestController
@RequestMapping("/auth")
public class AuthController {

	@Autowired
	AuthenticationManager authenticationManager;

	@Autowired
	JwtTokenProvider tokenProvider;

	@Autowired
	UserService userService;

	@Autowired
	ProjectService projectService;

	@Autowired
	AkisService akisService;

	@Autowired
	PasswordEncoder passwordEncode;

	@Autowired
	private JwtConfig jwtConfig;

	@PostMapping("/authenticate")
	public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequestDTO loginRequest) {

		String jwt = "";
		try {
			Authentication authentication = authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

			SecurityContextHolder.getContext().setAuthentication(authentication);

			jwt = tokenProvider.generateToken(authentication);
		} catch (Exception ex) {
			throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Yetkisiz Kullanıcı");
		}

		Optional<UserEntity> user = userService.findByNameAndPassword(loginRequest.getUsername(),
				loginRequest.getPassword());
		if (!user.isPresent()) {
			throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Yetkisiz Kullanıcı");
		}

		List<Proje> projectList = new ArrayList<Proje>();
		if (user.get().getDepoId() !=null) {
			user.get().setDepoAdi(akisService.getDepoList(user.get().getDepoId()).getAdi());
			projectList = projectService.getProjectList(new Long(user.get().getDepoId()));
		}

		return ResponseEntity.ok(new JwtAuthenticationResponseDTO(jwt, user.get(), projectList));

	}

	@RequestMapping(value = "/validateToken", method = RequestMethod.GET)
	public ResponseEntity<?> refreshtoken(HttpServletRequest request) throws Exception {
		// From the HttpRequest get the claims

		String token = getJwtFromRequest(request);

		if (tokenProvider.validateToken(token)) {
			return ResponseEntity.ok(new JwtAuthenticationRefreshDTO(token));
		}

		throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Yetkisiz Kullanıcı");
	}

	private String getJwtFromRequest(HttpServletRequest request) {
		String bearerToken = request.getHeader(jwtConfig.getHeader());
		if (StringUtils.hasText(bearerToken) && bearerToken.startsWith(jwtConfig.getPrefix())) {
			return bearerToken.substring(jwtConfig.getPrefix().length());
		}
		return null;
	}

}

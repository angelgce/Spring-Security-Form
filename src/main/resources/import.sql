INSERT INTO public.users(id, enable, password, username) VALUES (1, true, '$2a$10$0aH0dWIYf8AhdnVq.OtR9uAdsl/Lc40Pbd3xZga9WCUG7Rbzy20Ue', 'angel');
INSERT INTO public.users(id, enable, password, username) VALUES (2, true, '$2a$10$1abTSvwYUDfm5UyvcvLFo.iTLqWFBHppfmECdnib6xGLYmY8bO7HC', 'pedro');
INSERT INTO public.users(id, enable, password, username) VALUES (3, true, '$2a$10$wJoUTZ/fB2zx1zhcojs1qOZ8e2j4jBuCuvKgxxmTkQUzNZX.zNQl2', 'juan');
INSERT INTO public.users(id, enable, password, username) VALUES (4, true, '$2a$10$N4KJM8pwNBm0g1NkFpAoSeeg7FgXzrHssy6Ez7.XGQMYduSMlvjem', 'miguel');
 

INSERT INTO public.roles(id, role) VALUES (1, 'ROLE_ADMIN');
INSERT INTO public.roles(id, role) VALUES (2, 'ROLE_USER');
INSERT INTO public.roles(id, role) VALUES (3, 'ROLE_VIP');
INSERT INTO public.roles(id, role) VALUES (4, 'ROLE_MODERATOR');

INSERT INTO public.users_roles(user_id, roles_id) VALUES (1, 1);
INSERT INTO public.users_roles(user_id, roles_id) VALUES (2, 2);
INSERT INTO public.users_roles(user_id, roles_id) VALUES (2, 3);
INSERT INTO public.users_roles(user_id, roles_id) VALUES (2, 4);
INSERT INTO public.users_roles(user_id, roles_id) VALUES (3, 2);
INSERT INTO public.users_roles(user_id, roles_id) VALUES (4, 2);



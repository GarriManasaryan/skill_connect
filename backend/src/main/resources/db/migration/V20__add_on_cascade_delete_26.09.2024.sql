-- 1. Drop the existing foreign key constraint
ALTER TABLE sc_client_order_services
DROP CONSTRAINT fk_client_order_services_client_order_id;

-- 2. Add the foreign key with ON DELETE CASCADE
ALTER TABLE sc_client_order_services
ADD CONSTRAINT fk_client_order_services_client_order_id
FOREIGN KEY (client_order_id) REFERENCES sc_client_orders(id) ON DELETE CASCADE;

-- service_parent_id
ALTER TABLE sc_services
DROP CONSTRAINT fk_services_parent_id;

ALTER TABLE sc_services
ADD CONSTRAINT fk_services_parent_id
FOREIGN KEY (parent_id) REFERENCES sc_services(id) ON DELETE SET NULL;

-- fk_skills_parent_id
ALTER TABLE sc_skills
DROP CONSTRAINT fk_skills_parent_id;

ALTER TABLE sc_skills
ADD CONSTRAINT fk_skills_parent_id
FOREIGN KEY (parent_id) REFERENCES sc_skills(id) ON DELETE SET NULL;

-- fk_order_applications_client_order_id
ALTER TABLE sc_client_order_responses
DROP CONSTRAINT fk_order_applications_client_order_id;

ALTER TABLE sc_client_order_responses
ADD CONSTRAINT fk_client_order_responses_client_order_id
FOREIGN KEY (client_order_id) REFERENCES sc_client_orders(id) ON DELETE CASCADE;

-- fk_order_applications_profile_id
ALTER TABLE sc_client_order_responses
DROP CONSTRAINT fk_order_applications_profile_id;

ALTER TABLE sc_client_order_responses
ADD CONSTRAINT fk_client_order_responses_profile_id
FOREIGN KEY (profile_id) REFERENCES sc_profiles(id) ON DELETE CASCADE;

-- fk_client_order_services_service_id
ALTER TABLE sc_client_order_services
DROP CONSTRAINT fk_client_order_services_service_id;

ALTER TABLE sc_client_order_services
ADD CONSTRAINT fk_client_order_services_service_id
FOREIGN KEY (service_id) REFERENCES sc_services(id) ON DELETE CASCADE;

-- fk_client_orders_client_id
ALTER TABLE sc_client_orders
DROP CONSTRAINT fk_client_orders_client_id;

ALTER TABLE sc_client_orders
ADD CONSTRAINT fk_client_orders_client_id
FOREIGN KEY (client_id) REFERENCES sc_users(id) ON DELETE CASCADE;

-- fk_order_assignments_client_id
ALTER TABLE sc_order_assignments
DROP CONSTRAINT fk_order_assignments_client_id;

ALTER TABLE sc_order_assignments
ADD CONSTRAINT fk_order_assignments_client_id
FOREIGN KEY (client_id) REFERENCES sc_users(id) ON DELETE CASCADE;

-- fk_order_assignments_profile_id
ALTER TABLE sc_order_assignments
DROP CONSTRAINT fk_order_assignments_profile_id;

ALTER TABLE sc_order_assignments
ADD CONSTRAINT fk_order_assignments_profile_id
FOREIGN KEY (profile_id) REFERENCES sc_profiles(id) ON DELETE CASCADE;

-- fk_profile_services_profile_id
ALTER TABLE sc_profile_services
DROP CONSTRAINT fk_profile_services_profile_id;

ALTER TABLE sc_profile_services
ADD CONSTRAINT fk_profile_services_profile_id
FOREIGN KEY (profile_id) REFERENCES sc_profiles(id) ON DELETE CASCADE;

-- fk_profile_services_service_id
ALTER TABLE sc_profile_services
DROP CONSTRAINT fk_profile_services_service_id;

ALTER TABLE sc_profile_services
ADD CONSTRAINT fk_profile_services_service_id
FOREIGN KEY (service_id) REFERENCES sc_services(id) ON DELETE CASCADE;

-- fk_profile_skills_profile_id
ALTER TABLE sc_profile_skills
DROP CONSTRAINT fk_profile_skills_profile_id;

ALTER TABLE sc_profile_skills
ADD CONSTRAINT fk_profile_skills_profile_id
FOREIGN KEY (profile_id) REFERENCES sc_profiles(id) ON DELETE CASCADE;

-- fk_profile_skills_skill_id
ALTER TABLE sc_profile_skills
DROP CONSTRAINT fk_profile_skills_skill_id;

ALTER TABLE sc_profile_skills
ADD CONSTRAINT fk_profile_skills_skill_id
FOREIGN KEY (skill_id) REFERENCES sc_skills(id) ON DELETE CASCADE;

--fk_profiles_user_id
ALTER TABLE sc_profiles
DROP CONSTRAINT fk_profiles_user_id;

ALTER TABLE sc_profiles
ADD CONSTRAINT fk_profiles_user_id
FOREIGN KEY (user_id) REFERENCES sc_users(id) ON DELETE CASCADE;


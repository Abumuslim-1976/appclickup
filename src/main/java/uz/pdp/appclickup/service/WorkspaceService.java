package uz.pdp.appclickup.service;

import uz.pdp.appclickup.entity.User;
import uz.pdp.appclickup.payload.ApiResponse;
import uz.pdp.appclickup.payload.MemberDTO;
import uz.pdp.appclickup.payload.WorkspaceDTO;
import uz.pdp.appclickup.payload.WorkspaceRoleDto;

import java.util.List;
import java.util.UUID;


public interface WorkspaceService {

    ApiResponse addWorkspace(WorkspaceDTO workspaceDTO, User user);

    ApiResponse editWorkspace(WorkspaceDTO workspaceDTO);

    ApiResponse changeOwnerWorkspace(Long id, UUID ownerId);

    ApiResponse deleteWorkspace(Long id);

    ApiResponse addOrEditOrRemoveMember(Long id, MemberDTO memberDTO);

    ApiResponse joinToWorkspace(Long id, User user);

    List<MemberDTO> getMembersAndGuests(Long id);

    List<WorkspaceDTO> getWorkspaces(User user);

    ApiResponse addPermissionToRole(WorkspaceRoleDto workspaceRoleDto);

    ApiResponse removePermissionFromRole(WorkspaceRoleDto workspaceRoleDto);

    ApiResponse addRole(Long workspaceId, WorkspaceRoleDto workspaceRoleDto, User user);

}
